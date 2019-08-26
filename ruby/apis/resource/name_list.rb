require 'sinatra'
require 'sinatra/json'
require 'json'
require_relative '../../apis/store/user_detail_store'

get '/users' do
  json user_detail_store.get_all
end
get '/' do
  'Hello world!'
end

private

def user_detail_store
  UserDetailStore.new()
end

