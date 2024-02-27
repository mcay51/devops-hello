pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }
    environment {
        IMAGE_NAME = 'mcay51/devops-hello'
        IMAGE_USERNAME    = 'mcay51'
        IMAGE_TAG   = 'arm64'
        GIT_URL = 'https://github.com/mcay51/java_045_devops_pipeline'
    }

    stages {
        stage('Build Maven') {
            steps {
                 checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mcay51/java_045_devops_pipeline' ]])
                 sh 'mvn clean install'
                // bat 'mvn clean install'
            }
        }
        stage('Docker Image Build') {
            steps {
               sh 'docker build --platform linux/amd64 -t ${IMAGE_NAME} .'
                sh 'docker build  -t ${IMAGE_NAME}:arm64 .'
                 //bat 'docker build -t mcay51/devops-hello .'
            }
        }
        stage('Docker Push') {
            steps {
             script{
                withCredentials([string(credentialsId: 'jenkins-docker-hub-secret-text', variable: 'dockerhub')]) {
                          sh 'docker login -u ${IMAGE_USERNAME} -p ${dockerhub}'
                          sh 'docker push ${IMAGE_NAME}'
                          sh 'docker push ${IMAGE_NAME}:${IMAGE_TAG}'


                }

             }


            }
        }

    stage('Cleanup Docker Image') {
        steps {
            script{
                withCredentials([string(credentialsId: 'jenkins-docker-hub-secret-text', variable: 'dockerhub')]) {
                    sh 'docker rmi mcay51/devops-hello:latest'
                    sh 'docker rmi mcay51/devops-hello:arm64'

                }
            }
        }

    }
    }
}
