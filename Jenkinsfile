node {
    stage ("Build") {
        checkout scm
        bat("mvn verify")
    }

    stage ("Record issues") {
        recordIssues tool: pmdParser(pattern: '**/target/pmd.xml'), 
                             qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]
        recordIssues([tool: checkStyle(pattern: '**/target/checkstyle-result.xml'),
            sourceCodeEncoding: 'UTF-8',
            skipBlames: true,
            trendChartType: 'TOOLS_ONLY',
            qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]])
        recordIssues([tool: spotBugs(pattern: '**/target/spotbugsXml.xml'),
              sourceCodeEncoding: 'UTF-8',
              skipBlames: true,
              trendChartType: 'TOOLS_ONLY',
              qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]])
    }

    stage ("Publish reports") {
        publishHTML (target : [allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        useWrapperFileDirectly: false,
        reportDir: 'target/reports/',
        reportFiles: 'pmd.html,spotbugs.html',
        reportName: 'HTML Issues',
        reportTitles: 'PMD, Spotbugs'])
    }
}
