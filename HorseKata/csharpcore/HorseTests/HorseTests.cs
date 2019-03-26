using System;
using System.Collections.Generic;
using HorseKata;
using Xunit;
using Shouldly;

namespace HorseTests
{
    public class HorseTests
    {
        [Fact]
        public void FilterSortPaginate()
        {
            List<String> headers = SampleHorseData.GetSampleHeaders();
            List<List<Object>> tableData = SampleHorseData.GetSampleTableData();
            List<FilterMetadata> filters = SampleHorseData.GetSampleFilters();
            SortMetadata sortMetadata = SampleHorseData.GetSampleSortMetadata();
            PaginationMetadata paginationMetadata = SampleHorseData.GetSamplePaginationMetadata();
            var expectedTableData = new List<List<string>>
            {
                new List<string> {"Thoroughbred", "Bay", "1.6", "3", "true"},
                new List<string> {"Thoroughbred", "Grey", "1.55", "3", "true"}
            };
            
            PaginatedTable table = Horse.FilterSortPaginateTable(headers, tableData, filters, sortMetadata, paginationMetadata);
            
            table.Headers.ShouldBe(headers);
            table.TotalRows.ShouldBe(2);
            table.TableData.ShouldBe(expectedTableData);
        }
    }
}