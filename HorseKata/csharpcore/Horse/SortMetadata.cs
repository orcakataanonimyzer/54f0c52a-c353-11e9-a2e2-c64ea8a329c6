namespace HorseKata
{
    public class SortMetadata
    {
        private readonly string _columnHeader;
        private readonly string _sortOrder;

        public SortMetadata(string columnHeader, string sortOrder)
        {
            _columnHeader = columnHeader;
            _sortOrder = sortOrder;
        }
    }
}