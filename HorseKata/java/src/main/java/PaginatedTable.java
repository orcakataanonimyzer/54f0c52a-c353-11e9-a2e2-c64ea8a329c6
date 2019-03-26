import java.util.List;
import java.util.Objects;

/**
 * instances of this class can be returned to the front end for display
 */
public class PaginatedTable {
    /**
     * the headers for the table
     */
    final List<String> headers;

    /**
     * The data to show in the current page of the table
     */
    final List<List<String>> tableData;

    /**
     * the total number of rows, including those rows not shown on the current page
     */
    final int totalRows;

    public PaginatedTable(List<String> headers, List<List<String>> tableData, int totalRows) {
        this.headers = headers;
        this.tableData = tableData;
        this.totalRows = totalRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginatedTable that = (PaginatedTable) o;
        return totalRows == that.totalRows &&
                Objects.equals(headers, that.headers) &&
                Objects.equals(tableData, that.tableData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headers, tableData, totalRows);
    }
}