package guice;

import com.google.inject.Inject;

public class Controller {
    @Inject
    private AI ai;

    private BI bi;

    @Inject
    public Controller(BI bi){
        this.bi = bi;
    }

    public int getInt() {
        bi.execute();
        return this.ai.getInt() + bi.getSum();
    }
}
