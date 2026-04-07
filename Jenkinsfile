pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/juhii2004/mcp.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}