pipeline {

    agent any

    environment {

        PLATFORM = 'ios'
        APP = 'bs://a21a0af5e984f9fd39ff2150dc73697d8a275582'
        DEVICE_NAME = 'iPhone 15 Pro'
        PLATFORM_VERSION = '17.0'
        PROJECT_NAME = 'Appium Common Framework'
        BUILD_NAME = 'Appium Build 1'
    }

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