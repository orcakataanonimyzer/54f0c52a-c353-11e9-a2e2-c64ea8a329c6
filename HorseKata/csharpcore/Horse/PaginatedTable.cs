using System;
using System.Collections.Generic;

namespace HorseKata
{
    /**
 * instances of this class can be returned to the front end for display
 */
    public class PaginatedTable
    {
        /**
        * the headers for the table
        */
        public List<string> Headers { get; }

        /**
         * The data to show in the current page of the table
         */
        public List<List<string>> TableData { get; }

        /**
         * the total number of rows, including those rows not shown on the current page
         */
        public int TotalRows { get; }

        public PaginatedTable(List<string> headers, List<List<string>> tableData, int totalRows) 
        {
            Headers = headers;
            TableData = tableData;
            TotalRows = totalRows;
        }

        public override bool Equals(object o) 
        {
            if (this == o) return true;
            if (o == null || GetType() != o.GetType()) return false;
            PaginatedTable that = (PaginatedTable) o;
            return TotalRows == that.TotalRows &&
                   Equals(Headers, that.Headers) &&
                   Equals(TableData, that.TableData);
        }

        public override int GetHashCode()
        {
            return Tuple.Create(Headers, TableData, TotalRows).GetHashCode();
        }
    }
}