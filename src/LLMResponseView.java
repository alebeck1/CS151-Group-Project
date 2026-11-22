/**
 * (CorndogCat/Alexander Fleming/Micael Colon/Aidan Lebeck) - How this LLMResponseView interacts with the
 * swing components seems a little vague. So I've made the assumption that
 * the LLMResponseView has a Jpanel that it updates and the main view class will
 * hold the LLMResponseViews.
 *
 * When the main view class is made, it should add these panels by getting them
 *      from the LLMResponseView.
 * */
public class LLMResponseView implements ModelObserver {
    private final String modelString;
    private ResponsePanel panel;
    private QuerySession model;

    /**
     * Constructor, makes an LLMResponseView for the specified LLM.
     * @param modelString the name of the LLM
     * @param model QuerySession model being observed
     */
    public LLMResponseView(String modelString,  QuerySession model) {
        this.modelString = modelString;
        this.model = model;
        panel = new ResponsePanel(modelString);
    }

    /**
     * Updates the view when model notifies observers.
     */
    @Override
    public void modelChanged() {
        LLMResponse response = model.getResponse(modelString);
        if (response != null) {
            panel.setModelName(response.getModelName());
            panel.setResponse(response.getText());
            panel.setWaitTime(response.getStatus().toString());
            panel.updatePanel();
        }

    }

    /**
     * Getter for the panel associated with the view.
     * @return the ResponsePanel
     */
    public ResponsePanel getPanel() {
        return panel;
    }
}
