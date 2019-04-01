
public class PaginationMetadata {
    final int firstRecordInPage;
    final int pageSize;

    public PaginationMetadata(int firstRecordInPage, int pageSize) {
        this.firstRecordInPage = firstRecordInPage;
        this.pageSize = pageSize;
    }
}