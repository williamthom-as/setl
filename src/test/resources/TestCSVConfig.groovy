//options {
//    queueLimit(200)
//
//}

input {
    type(csv) {
        filepath "src/test/resources/unsectioned_csv.csv"
        headers 0
        chunk 200
    }
}

//process {
//    // ignore first n records
//
//    identity("col_1").extract(all).capitalize.shorten(4).lengthen(4, "x").mapTo("col_1_output")
//    identity("col_3").extract.all.variableReplace("VARIABLE_1").mapTo("col_3_output")
//    identity("col_2").extract.all.mapTo("col_2")
//}

output {
    type(csv) {
        filepath "/tmp/setl.csv"
    }
}
