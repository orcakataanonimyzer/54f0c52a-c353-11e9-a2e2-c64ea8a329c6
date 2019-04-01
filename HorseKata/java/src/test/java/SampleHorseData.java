import java.util.Arrays;
import java.util.List;

class SampleHorseData {

    static List<String> GetSampleHeaders() {
        return Arrays.asList("Breed", "Colour", "Height", "Age", "Shoes");
    }

    static List<List<Object>> GetSampleTableData() {
        return Arrays.asList(
                Arrays.asList("Thoroughbred", "Bay", 1.60, 3, true),
                Arrays.asList("Thoroughbred", "Grey", 1.55, 3, true),
                Arrays.asList("Arabian horse", "Bay", 1.51, 5, true),
                Arrays.asList("Shetland Pony", "Black", 1.01, 2, false),
                Arrays.asList("Shire horse", "Black", 1.71, 4, true)
        );
    }

    static List<FilterMetadata> GetSampleFilters() {
        return Arrays.asList(
                new FilterMetadata("Breed", "Thoroughbred"),
                new FilterMetadata("Age", 3)
        );
    }

    static SortMetadata GetSampleSortMetadata() {
        return new SortMetadata("Height", "Ascending");
    }

    static PaginationMetadata GetSamplePaginationMetadata() {
        return new PaginationMetadata(1, 3);
    }
}
