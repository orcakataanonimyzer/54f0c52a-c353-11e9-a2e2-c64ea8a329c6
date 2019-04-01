import java.util.List;
import java.util.Objects;

public class PaginatedTable {
    final List<String> headers;
    final List<List<String>> tableData;
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