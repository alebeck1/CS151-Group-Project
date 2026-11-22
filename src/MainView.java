import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * The main GUI for the program.
 */
public class MainView extends JFrame {
    private JTextField promptField;
    private JButton submitButton;
    private JPanel mainPanel;
    private List<LLMResponseView> responseViewList;

    /**
     * Constructor
     * Makes the llm response views, registers observers, and sets the GUI elements.
     * (Can definitely be made to look better than it is right now)
     * @param model the model that is observed by the response views
     */
    public MainView(QuerySession model) {
        responseViewList = new ArrayList<>();
        LLMResponseView llamaView = new LLMResponseView("Llama", model);
        LLMResponseView gemmaView = new LLMResponseView("Gemma", model);
        LLMResponseView qwenView = new LLMResponseView("Qwen", model);

        responseViewList.add(llamaView);
        responseViewList.add(gemmaView);
        responseViewList.add(qwenView);

        model.addObserver(llamaView);
        model.addObserver(gemmaView);
        model.addObserver(qwenView);

        setTitle("Multi-Model AI Study Assistant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(940, 580);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel promptPanel = new JPanel();
        promptField = new JTextField(40);
        submitButton = new JButton("Ask Models");
        promptPanel.add(promptField);
        promptPanel.add(submitButton);

        mainPanel.add(promptPanel, BorderLayout.NORTH);

        JPanel llmResponsePanel = new JPanel();
        llmResponsePanel.setLayout(new GridLayout(1, 3, 10, 5));

        llmResponsePanel.add(llamaView.getPanel());
        llmResponsePanel.add(gemmaView.getPanel());
        llmResponsePanel.add(qwenView.getPanel());

        mainPanel.add(llmResponsePanel, BorderLayout.CENTER);
        add(mainPanel);

    }
}
