pipeline {
    agent any
    tools {
        maven 'MAVEN-3.8.4'
    }
    environment {
        DOCKER_TAG = "${BUILD_NUMBER}"
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/vyoubi/hc-inventory-service']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker version'
                sh 'docker build -t hc-inventory-service .'
                sh 'docker image list'
                sh 'docker tag hc-inventory-service valere1991/hc-inventory-service:${DOCKER_TAG}'
            }
        }
        stage('Docker Hub login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Dockerhub-Val', passwordVariable: 'password', usernameVariable: 'username')]) {
                sh 'docker login -u $username -p $password'
                }
            }
        }
        stage('Push image to Docker Hub') {
            steps {
                sh 'docker push valere1991/hc-inventory-service:${DOCKER_TAG}'
            }
        }
        stage("remove unused docker image"){
            steps{
            sh 'docker rmi hc-inventory-service -f'
            sh 'docker rmi valere1991/hc-inventory-service:${DOCKER_TAG} -f'
         }
        }
    }
}
