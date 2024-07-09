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
                sh "docker build -t=kenavm/selenium:latest ."
            }
        }

        stage('push image'){
            environment{
                DOCKER_HUB = credentials('e2a045a0-e6a4-468c-abf0-700f258e6e2b')
            }
            steps{
               sh 'echo ${DOCKER_HUB_PSW} | docker login -u ${DOCKER_HUB_USR} --password-stdin'
               sh "docker push kenavm/selenium:latest"
               sh "docker tag kenavm/selenium:latest kenavm/selenium:${env.BUILD_NUMBER}"
               sh "docker push kenavm/selenium:${env.BUILD_NUMBER}"
            }
        }

    }

    post {
        always {
            sh "docker logout"
        }
    }
}