using System;
using System.Collections.Generic;

namespace HorseKata
{
    public class Horse
    {

        // This method is called by the front end when it wants to display a page of horse data.
        public static PaginatedTable FilterSortPaginateTable(
            List<string> headers,
            List<List<object>> tableData,
            List<FilterMetadata> filters,
            SortMetadata sortMetadata,
            PaginationMetadata paginationMetadata)
        {
            // TODO: filter horse table using filters

            // TODO: sort horse table using sortMetadata

            // TODO: paginate horse table using paginationMetadata

            throw new NotImplementedException();
        }
    }
}