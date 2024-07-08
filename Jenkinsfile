pipeline{

    agent any

    stages{

        stage('build jar'){
            steps{
                sh "mvn clean package -DskipTests"

            }
        }

        stage('build image'){
            steps{
                sh "docker build -t=kenavm/selenium ."
            }
        }

        stage('push image'){
            steps{
               sh "docker push kenavm/selenium"
            }
        }

        stage('selenium-test'){
            steps{
               build job: 'SELENIUM_DOCKER_RUNNER', parameters: [string(name: 'BROWSER', value: 'firefox')]
            }
        }

        stage('deploy-to-prod'){
            steps{
               echo "deploying flight-reservation app to PROD env"
            }
        }

    }

}