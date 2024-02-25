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

        stage('Docker Image') {
            steps {
                // bat 'docker build -t mcay51/devops-application .'
                 sh 'docker build -t mcay51/devops-application .'
            }
        }


        stage('Docker Image to DockerHub') {
            steps {
              script{
                  withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {
                   sh 'echo docker login -u mcay51 -p ${dockerhub}'
                   sh 'docker push mcay51/devops-hello:latest'
                }
              }
            }
        }

        /*
        stage('Deploy to Kubernetes') {
            steps {
              script{
                  kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'kubernetes')
              }
            }
        }
        */


    }
}
