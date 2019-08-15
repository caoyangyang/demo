#!/bin/sh

#run sh to get config from consul and set env  variable
. /usr/local/bin/consul.sh

# nginx config
config_file=/etc/nginx/nginx.conf
AUTH_CONTENT='auth_basic "Who are you?";\n  auth_basic_user_file /etc/nginx/passwd;'

sed -i \
    -e "s@#APOLLO#@$APOLLO@g" \
    -e "s@#MEDIA_S3#@$MEDIA_S3@g" \
	-e "s@#REQUEST_PROTOCOL#@$REQUEST_PROTOCOL@g" \
$config_file

find . -type f|grep -E ".html$" | xargs sed -i \
    -e "s@%GTM_CONTAINER_ID%@$GTM_CONTAINER_ID@g"

# Nginx Proxy
sed -i \
    -e "s@#NODE1#@$NODE1@g" \
    -e "s@#NODE2#@$NODE2@g" \
/etc/nginx/nginx_proxy.conf

if [ ! -z $NODE1 ] && [ ! -z $NODE2 ]; then
	PROXY_CONTENT='include nginx_proxy.conf;'
	sed -i \
	    -e "s@#NGINX_PROXY#@$PROXY_CONTENT@g" \
	$config_file
fi


if [ ! -z $AUTH_USER ] && [ ! -z $AUTH_PASS ]; then
	htpasswd -bc /etc/nginx/passwd $AUTH_USER $AUTH_PASS
fi

if [ -f /etc/nginx/passwd ]; then
	sed -i \
	    -e "s@#AUTH_BASIC_USER_FILE#@$AUTH_CONTENT@g" \
	$config_file
fi

# Nginx prod configs
if [ "$ENV" == "prod" ]; then
	sed -i \
	    -e "s@#MAIN_HEADER#@include /etc/nginx/conf.d/head_prod.conf;@g" \
	    -e "s@#CACHES_HEADER#@include /etc/nginx/conf.d/caches_head.conf;@g" \
	    -e "s@#CACHES_BLOCK#@include /etc/nginx/conf.d/caches.conf;@g" \
	$config_file

	# create cache folders
	mkdir -p /var/opt/nginx

	# mapping APOLLO
	sed -i \
		-e "s@#APOLLO#@$APOLLO@g" \
	/etc/nginx/conf.d/caches.conf
else
	sed -i \
	    -e "s@#MAIN_HEADER#@include /etc/nginx/conf.d/head_dev.conf;@g" \
	$config_file
fi

# Replace env.js by environment variables
if [ ! -z $REACT_APP_PIWIK_SITE_ID ]; then
	sed -i \
	    -e "s/REACT_APP_PIWIK_SITE_ID.*$/REACT_APP_PIWIK_SITE_ID = '$REACT_APP_PIWIK_SITE_ID';/g" \
	/usr/share/nginx/web-costa/env.js
fi

if [ ! -z $REACT_APP_MIAOZHEN_SITE_ID ]; then
	sed -i \
	    -e "s/REACT_APP_MIAOZHEN_SITE_ID.*$/REACT_APP_MIAOZHEN_SITE_ID = '$REACT_APP_MIAOZHEN_SITE_ID';/g" \
	/usr/share/nginx/web-costa/env.js
fi

if [ ! -z $REACT_APP_TRACKING_ENABLED ]; then
	sed -i \
	    -e "s/REACT_APP_TRACKING_ENABLED.*$/REACT_APP_TRACKING_ENABLED = $REACT_APP_TRACKING_ENABLED;/g" \
	/usr/share/nginx/web-costa/env.js
fi

# Status
echo "Using $APOLLO as backend service..."

exec "$@"
