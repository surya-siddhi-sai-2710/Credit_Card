pipeline {
    agent any
    stages {
        stage('git checkout') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/surya-siddhi-sai-2710/Credit_Card.git'
                }
            }
        }
        stage('UNIT testing') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Maven build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
    }
}
