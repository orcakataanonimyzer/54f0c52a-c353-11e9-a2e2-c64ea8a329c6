import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Horse {

    public static PaginatedTable FilterSortPaginateTable(
            List<String> headers,
            List<List<Object>> tableData,
            List<FilterMetadata> filters,
            SortMetadata sortMetadata,
            PaginationMetadata paginationMetadata) {
        // TODO: filter horse table using filters
        // TODO: sort horse table using sortMetadata
        // TODO: paginate horse table using paginationMetadata
        List<List<String>> dataList = stringifyList(tableData);
        List<List<String>> filtered =  filterData(headers,dataList,filters);
        List<List<String>> setOfLists = removeDupicates(filtered);
        PaginatedTable table = new PaginatedTable(headers,setOfLists,setOfLists.size());

        return table;
    }

    private static List<List<String>> filterData(List<String> headers, List<List<String>> data, List<FilterMetadata> filters){
        List<List<String>> filteredData = new LinkedList<>();
        for (FilterMetadata fm :filters) {
           int location =  headers.indexOf(fm.columnHeader);
           String searched = fm.value.toString();
           //List<String> strings = data.stream().filter(o ->  )

           for (List l : data) {
                if(l.get(location).equals(searched)){
                    filteredData.add(l);
                }
            }
        }
        return filteredData;
    }

    private static List<List<String>> stringifyList(List<List<Object>> objectLists){
        List<List<String>> strings;
        strings = objectLists.stream()
                .map(list -> list.stream().map(o -> o.toString()).collect(Collectors.toList()))
                .collect(Collectors.toList());
        return strings;
    }
    private static List<List<String>> removeDupicates(List<List<String>> lists){
        List<List<String>> setOfLists = new LinkedList<>();
        setOfLists.add(lists.get(0));
        for (List l : lists) {
            if (!setOfLists.contains(l)){
                setOfLists.add(l);
            }
        }
        return setOfLists;
    }
}
