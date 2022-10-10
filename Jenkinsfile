def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                  def mapList = []
def headers = []
new File("SynthiaProd_data.csv").readLines().eachWithIndex { row, rowIndex ->
    if (rowIndex == 0) { headers = row.split(',') }
    else {
        def tmpMap = [:]
        def cells = row.split(',').eachWithIndex { cell, cellIndex ->
          tmpMap[headers[cellIndex]] = cell
        }
        mapList.add(tmpMap)
    }
}
                }
            }
        }