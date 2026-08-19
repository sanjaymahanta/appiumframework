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

                withCredentials([
                    usernamePassword(
                        credentialsId: 'browserstack-credentials',
                        usernameVariable: 'BROWSERSTACK_USERNAME',
                        passwordVariable: 'BROWSERSTACK_ACCESS_KEY'
                    )
                ]) {

                    bat 'mvn clean test'

                }
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