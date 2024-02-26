pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {
        stage('Build Maven') {
            steps {
                 checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mcay51/java_045_devops_pipeline']])
                 sh 'mvn clean install'
                 //bat 'mvn clean install'
            }
        }



    }
}
