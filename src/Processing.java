import processing.core.PApplet;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Processing extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Processing", args);
    }

    public void settings() {
        size(1920, 1080);
    }

    public void setup() {
        RenderingTypes type = RenderingTypes.BoneRenderer;

        switch (type) {
            case Scratchpad:
                break;
            case FenceRenderer:
                FenceRenderer.draw(this);
                break;
            case SpiralRenderer:
                SpiralRenderer.draw(this);
                break;
            case FuzzBallRenderer:
                FuzzBallRenderer.draw(this);
                break;
            case SkylineRenderer:
                SkylineRenderer.draw(this);
                break;
            case BoneRenderer:
                BoneRenderer.draw(this);
                break;
        }

        saveImageWithTimestamp(type);
    }

    private void saveImageWithTimestamp(RenderingTypes type) {
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();
        saveFrame(absolutePath + "\\Images\\" + type.name() + "_" + System.currentTimeMillis() + ".png");
    }
}
