module.exports = function (grunt) {
    require('load-grunt-tasks')(grunt);
    grunt.initConfig({
        less: {
            compile: {
                files: {
                    'css/test.css': 'css/test.less'
                }
            }
        },
        watch: {
            scripts: {
                files: ['css/*.less'],
                tasks: ['less']
            }
        },
        shell: {
            ruby: {
                options: {
                    stdout: true,
                    stderr: true
                },
                command: 'ruby apis/resource/name_list.rb'
            }
        },
        concurrent: {
            development: {
                options: {
                    logConcurrentOutput: true
                },
                tasks: ['shell:ruby']
            }
        },
        copy: {
            main: {
                files: [
                    // flattens results to a single level
                    {
                        expand: true,
                        cwd:'node_modules/semantic-ui/',
                        src: ['dist/**'],
                        dest: 'views/css/'
                    },
                    {
                        expand: true,
                        cwd:'bower_components/',
                        src: ['font-awesome/**'],
                        dest: 'views/'
                    },
                    {
                        expand: true,
                        flatten: true,
                        src: ['node_modules/semantic-ui/dist/semantic.min.js','node_modules/jquery/dist/jquery.min.js'],
                        dest: 'views/js/', filter: 'isFile'
                    }
                ],
            },
        }
    });

    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');

    grunt.registerTask('default', ['copy','shell:ruby']);
};