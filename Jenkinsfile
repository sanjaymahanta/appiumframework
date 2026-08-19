pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/sanjaymahanta/appiumframework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            echo 'Test execution completed'
        }

        success {
            echo 'Tests PASSED'
        }

        failure {
            echo 'Tests FAILED'
        }
    }
}