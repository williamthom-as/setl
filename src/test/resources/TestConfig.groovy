source {
    stream {
        type csv
        opts {
            filepath "some_file"
        }
    }

    variables {
        VARIABLE_1 = "var_1"
        VARIABLE_2 = "var_2"
    }

    content {
        section(1, 10) {
            headers(0)

            workflow {
                stage("build") {

                }

                stage("transform") {
                    column("col_1").extract.all.capitalize.shorten(4).mapTo("col_1_output")
                    column("col_2").extract.all.mapTo("col_2")
                }

                stage("export") {
                    output
                }
            }
        }
    }
}
