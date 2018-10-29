package events;

import common.BaseEvent;
import modal.SearchResult;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class SearchQueryEvent extends BaseEvent {
    public static final OnLoadingError FAILED
            = new OnLoadingError(UNHANDLED_MSG, UNHANDLED_CODE);

    public static class OnLoaded extends OnDone<SearchResult> {
        public OnLoaded(SearchResult searchResult) {
            super(searchResult);
        }
    }

    public static class OnLoadingStart extends OnStart<String> {
        public OnLoadingStart(String message) {
            super(message);
        }
    }

    public static class OnLoadingError extends OnFailed {
        public OnLoadingError(String errorMessage, int code) {
            super(errorMessage, code);
        }
    }
}
