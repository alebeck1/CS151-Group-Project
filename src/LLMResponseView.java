/**
 * (CorndogCat/Alexander Fleming/Micael Colon) - How this LLMResponseView interacts with the
 * swing components seems a little vague. So I've made the assumption that
 * the LLMResponseView has a Jpanel that it updates and the main view class will
 * hold the LLMResponseViews.
 *
 * When the main view class is made, it should add these panels by getting them
 *      from the LLMResponseView.
 * */
public class LLMResponseView implements ModelObserver {
    private final String modelString;
    private final QuerySession session;
    private ResponsePanel panel;

    public LLMResponseView(String modelString) {
        this.modelString = modelString;
        this.session = new QuerySession();
        panel = new ResponsePanel(modelString);
    }

    @Override
    public void modelChanged() {

    }

    public ResponsePanel getPanel() {
        return panel;
    }
}
