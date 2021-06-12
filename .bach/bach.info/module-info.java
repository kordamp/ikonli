import com.github.sormuras.bach.api.ProjectInfo;
import com.github.sormuras.bach.api.ProjectInfo.Tool;
import com.github.sormuras.bach.api.ProjectInfo.Tweak;

@ProjectInfo(
    version = "12.3.1",

    tool = @Tool(
        tweaks = {@Tweak(
            tool = "javac",
            with = "-encoding",
            more = "UTF-8"
        ), @Tweak(
            tool = "javac",
            with = "--processor-path",
            more = ".bach/external-modules/jipsy-processor-1.1.1.jar:.bach/external-modules/org.kordamp.jipsy.annotations.jar"
        ), @Tweak(
            tool = "javac",
            with = "--default-module-for-created-files",
            more = "org.kordamp.ikonli.core"
        ), @Tweak(
            tool = "jlink",
            with = "--launcher",
            more = "browxer=org.kordamp.ikonli.browser/org.kordamp.ikonli.browser.Launcher"
        )}
    )
)
module bach.info {
    requires com.github.sormuras.bach;
}