import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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
        headers = SampleHorseData.GetSampleHeaders();
        tableData = SampleHorseData.GetSampleTableData();
        filters = SampleHorseData.GetSampleFilters();
        sortMetadata = SampleHorseData.GetSampleSortMetadata();
        paginationMetadata = SampleHorseData.GetSamplePaginationMetadata();

        table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);
    }

    @Test
    public void FilterSortPaginate() {
        assertEquals(headers, table.headers);
        assertEquals(2, table.totalRows);
        assertEquals(Arrays.asList(Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")), table.tableData);
    }

    @Test
    public void headersAreCorrect(){
        assertEquals(headers, table.headers);
    }

    @Test
    public void totalRowsCount(){
        assertEquals(2, table.totalRows);
    }

    @Test
    public void filteredRowsOfData(){
        assertEquals(Arrays.asList(Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")), table.tableData);

    }
}
