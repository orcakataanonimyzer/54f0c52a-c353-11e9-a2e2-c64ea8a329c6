import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HorseTest
{
    @Test
    public void FilterSortPaginate()
    {
        List<String> headers = SampleHorseData.GetSampleHeaders();
        List<List<Object>> tableData = SampleHorseData.GetSampleTableData();
        List<FilterMetadata> filters = SampleHorseData.GetSampleFilters();
        SortMetadata sortMetadata = SampleHorseData.GetSampleSortMetadata();
        PaginationMetadata paginationMetadata = SampleHorseData.GetSamplePaginationMetadata();
        PaginatedTable table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);
        assertEquals(headers, table.headers);
        assertEquals(2, table.totalRows);
        assertEquals(Arrays.asList(Arrays.asList("Thoroughbred", "Bay", "1.6", "3", "true"),
                Arrays.asList("Thoroughbred", "Grey", "1.55", "3", "true")), table.tableData);
    }
}
