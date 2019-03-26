namespace HorseKata
{
    public class FilterMetadata
    {
        private readonly string _columnHeader;
        private readonly object _value;

        public FilterMetadata(string columnHeader, object value) 
        {
            _columnHeader = columnHeader;
            _value = value;
        }
    }
}