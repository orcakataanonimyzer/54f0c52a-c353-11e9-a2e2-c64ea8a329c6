namespace HorseKata
{
    /**
    * The front end provides this data about the requested pagination
    */
    public class PaginationMetadata 
    {
        /**
         * the index of the first record to be shown in the current page of data
         */
        private readonly int _firstRecordInPage;

        /**
         * the number of rows to show in this page
         */
        private readonly int _pageSize;

        public PaginationMetadata(int firstRecordInPage, int pageSize) 
        {
            _firstRecordInPage = firstRecordInPage;
            _pageSize = pageSize;
        }
    }
}