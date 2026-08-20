pipeline {

    agent any

    environment {

        PLATFORM = 'ios'

        APP = 'bs://de5e892d3b0328be80a291eef9c294d50c120854'

        DEVICE_NAME = 'iPhone 15 Pro'

        PLATFORM_VERSION = '17.0'

        PROJECT_NAME = 'Appium Common Framework'

        BUILD_NAME = 'Appium Build 1'
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'main',
                    url: 'https://github.com/sanjaymahanta/appiumcommonframework.git'
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