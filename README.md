[![Run tests](https://github.com/williamthom-as/setl/actions/workflows/test.yaml/badge.svg)](https://github.com/williamthom-as/setl/actions/workflows/test.yaml)

# setl

Stream, extract, transform, load from and to different data streams. 

Not functional yet, please check back later.

## Example Config

```groovy
input {
    type(csv) {
        filepath "my_location/unsectioned_csv.csv"
        headers 0
        chunk 50
    }
}

process {
    identity("col_1").extract(all).capitalize.shorten(4).lengthen(4, "x").mapTo("col_1_output")
    identity("col_3").extract.all.variableReplace("VARIABLE_1").mapTo("col_3_output")
    identity("col_2").extract.all.mapTo("col_2_output")
}

output {
    type(http) {
        addr "http://localhost:3000"
        endpoint "/data"
        method post
        authentication none
    }

    type(csv) {
        filepath "my_location/export.csv"
    }
}
```
