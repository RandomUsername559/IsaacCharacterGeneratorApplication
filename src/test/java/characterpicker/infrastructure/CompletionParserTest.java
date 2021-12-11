package characterpicker.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CompletionParserTest {
    @Test
    void shouldIgnoreCompletionCaseWhenAllUpperCase() {

        //GIVEN
        String upperCaseCompletion = "ISAAC,MOTHER,???";

        //WHEN
        List<String> result = CompletionParser.parse(upperCaseCompletion);

        //THEN
        List<String> expectedCompletionList = List.of(
                "isaac",
                "mother",
                "???"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldIgnoreCompletionCaseWhenVaryingCase() {

        //GIVEN
        String varyingCaseCompletions = "iSaAC,mOTheR,???";

        //WHEN
        List<String> result = CompletionParser.parse(varyingCaseCompletions);

        //THEN
        List<String> expectedCompletionList = List.of(
                "isaac",
                "mother",
                "???"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldParseOneElement() {

        //GIVEN
        String varyingCaseSingleCompletion = "iSaAC";

        //WHEN
        List<String> result = CompletionParser.parse(varyingCaseSingleCompletion);

        //THEN
        List<String> expectedCompletionList = List.of(
                "isaac"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldParseNoElements() {

        //GIVEN
        String emptyElement = "";

        //WHEN
        List<String> result = CompletionParser.parse(emptyElement);

        //THEN
        List<String> expectedCompletionList = List.of(

        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldIgnoreNoElementsBetweenSplitter() {

        //GIVEN
        String splitter = ",";

        //WHEN
        List<String> result = CompletionParser.parse(splitter);

        //THEN
        List<String> expectedCompletionList = List.of(

        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldSkipEmptyElement() {

        //GIVEN
        String splittersSurroundingElement = ",isaac,";

        //WHEN
        List<String> result = CompletionParser.parse(splittersSurroundingElement);

        //THEN
        List<String> expectedCompletionList = List.of(
                "isaac"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldSkipEmptyElements() {

        //GIVEN
        String completionsWithExtraSplitters = "satan,,isaac";

        //WHEN
        List<String> result = CompletionParser.parse(completionsWithExtraSplitters);

        //THEN
        List<String> expectedCompletionList = List.of(
                "satan",
                "isaac"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldIgnoreSplitters() {

        //GIVEN
        String onlySplitters = ",,,,,,,";

        //WHEN
        List<String> result = CompletionParser.parse(onlySplitters);

        //THEN
        List<String> expectedCompletionList = List.of(

        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }

    @Test
    void shouldStrip() {

        //GIVEN
        String completionsWithExtraSpaces = " satan         ,, isaac ";

        //WHEN
        List<String> result = CompletionParser.parse(completionsWithExtraSpaces);

        //THEN
        List<String> expectedCompletionList = List.of(
                "satan",
                "isaac"
        );
        Assertions.assertThat(result).isEqualTo(expectedCompletionList);
    }
}
