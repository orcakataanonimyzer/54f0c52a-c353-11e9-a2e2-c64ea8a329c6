import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Horse {

    public static PaginatedTable FilterSortPaginateTable(
            List<String> headers,
            List<List<Object>> tableData,
            List<FilterMetadata> filters,
            SortMetadata sortMetadata,
            PaginationMetadata paginationMetadata) {

        List<List<Object>> filtered =  filterData(headers,tableData,filters);
        List<List<String>> dataList = stringifyList(filtered);
        List<List<String>> sorted = sortList(dataList,headers,sortMetadata);
        List<List<String>> paginated = paginateList(sorted,paginationMetadata);
        PaginatedTable table = new PaginatedTable(headers,paginated, paginated.size());

        return table;
    }

    private static List<List<Object>> filterData(List<String> headers, List<List<Object>> data, List<FilterMetadata> filters) {
        if (filters.isEmpty()){
            return data;
        }
        List<List<Object>> filtered = new LinkedList<>();
        for (List row : data) {
            boolean matchesAllFilters = true;
            for (FilterMetadata filter : filters) {
                int index = headers.indexOf(filter.columnHeader);
                if (row.get(index) != filter.value) {
                    matchesAllFilters = false;
                }
            }
            if (matchesAllFilters) {
                filtered.add(row);
            }
        }
        return filtered;
    }

    private static List<List<String>> sortList(List<List<String>> data, List<String> headers, SortMetadata sortMetadata){
       if(sortMetadata.columnHeader.equals("")){
           return data;
       }
       int index= headers.indexOf(sortMetadata.columnHeader);
        List<List<String>> sortedList =  data.stream().sorted(Comparator.comparing(row -> row.get(index))).collect(Collectors.toList());
       if(sortMetadata.sortOrder.equals("Descending")){
           Collections.reverse(sortedList);
       }
       return sortedList;
    }

    private static List<List<String>> paginateList(List<List<String>> data, PaginationMetadata paginationMetadata){
        if(paginationMetadata.firstRecordInPage == 0){
            return data;
        }
        return  data.subList(paginationMetadata.firstRecordInPage -1, paginationMetadata.pageSize);
    }

    private static List<List<String>> stringifyList(List<List<Object>> data){
        List<List<String>> strings;
        strings = data.stream()
                .map(list -> list.stream().map(o -> o.toString()).collect(Collectors.toList()))
                .collect(Collectors.toList());
        return strings;
    }
}
