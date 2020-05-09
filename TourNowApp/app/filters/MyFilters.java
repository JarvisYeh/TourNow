package filters;
import play.mvc.EssentialFilter;
import play.filters.hosts.AllowedHostsFilter;
import play.http.DefaultHttpFilters;

import javax.inject.Inject;

public class MyFilters extends DefaultHttpFilters {
    @Inject public MyFilters(AllowedHostsFilter allowedHostsFilter) {
        super(allowedHostsFilter);
    }
}