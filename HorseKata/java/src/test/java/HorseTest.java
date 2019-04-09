import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HorseTest {
    private List<String> headers;
    private List<List<Object>> tableData;
    private List<FilterMetadata> filters;
    private SortMetadata sortMetadata;
    private PaginationMetadata paginationMetadata;
    private PaginatedTable table;

    @Before
    public void setup(){
        headers = new ArrayList<>();
        tableData = new LinkedList<>();
        filters = new ArrayList<>();
        sortMetadata = new SortMetadata("","");
        paginationMetadata = new PaginationMetadata(0,0);

    }

    @Test
    public void headersAreCorrect(){
        headers = SampleHorseData.GetSampleHeaders();
        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(headers, table.headers);
    }

    @Test
    public void totalRowsCount(){
        headers = SampleHorseData.GetSampleHeaders();
        tableData = SampleHorseData.GetSampleTableData();
        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(5, table.totalRows);
    }

    @Test
    public void filteredRowsOfData(){
       headers = SampleHorseData.GetSampleHeaders();
       tableData = SampleHorseData.GetSampleTableData();
       filters = SampleHorseData.GetSampleFilters();
       table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

       assertEquals(Arrays.asList(Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")), table.tableData);
    }

    @Test
    public void sortRows_byHeightAscending(){
        headers = SampleHorseData.GetSampleHeaders();
        tableData = SampleHorseData.GetSampleTableData();
        sortMetadata = SampleHorseData.GetSampleSortMetadata();

        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(Arrays.asList(
                Arrays.asList("Shetland Pony", "Black", "1.01", "2", "false"),
                Arrays.asList("Arabian horse", "Bay", "1.51", "5", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true"),
                Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Shire horse", "Black", "1.71", "4", "true")
                ), table.tableData);
    }

    @Test
    public void sortRows_byHeightDescending(){
        headers = SampleHorseData.GetSampleHeaders();
        tableData = SampleHorseData.GetSampleTableData();
        sortMetadata = new SortMetadata("Height", "Descending");;

        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(Arrays.asList(
                Arrays.asList("Shire horse", "Black", "1.71", "4", "true"),
                Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true"),
                Arrays.asList("Arabian horse", "Bay", "1.51", "5", "true"),
                Arrays.asList("Shetland Pony", "Black", "1.01", "2", "false")
                ), table.tableData);
    }

    @Test
    public void paginateData_fromIndex1_pageSize3(){
        headers = SampleHorseData.GetSampleHeaders();
        tableData = SampleHorseData.GetSampleTableData();
        sortMetadata = SampleHorseData.GetSampleSortMetadata();
        paginationMetadata = SampleHorseData.GetSamplePaginationMetadata();

        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);

        assertEquals(Arrays.asList(
                Arrays.asList("Shetland Pony", "Black", "1.01", "2", "false"),
                Arrays.asList("Arabian horse", "Bay", "1.51", "5", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")
        ), table.tableData);
    }

}
