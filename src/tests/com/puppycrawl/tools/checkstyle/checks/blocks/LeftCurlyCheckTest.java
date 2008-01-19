package com.puppycrawl.tools.checkstyle.checks.blocks;

import com.puppycrawl.tools.checkstyle.BaseCheckTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import org.junit.Before;
import org.junit.Test;

public class LeftCurlyCheckTest extends BaseCheckTestSupport
{
    private DefaultConfiguration mCheckConfig;

    @Before
    public void setUp()
    {
        mCheckConfig = createCheckConfig(LeftCurlyCheck.class);
    }

    @Test
    public void testDefault() throws Exception
    {
        final String[] expected = {
            "8:1: '{' should be on the previous line.",
            "12:5: '{' should be on the previous line.",
            "21:5: '{' should be on the previous line.",
            "30:5: '{' should be on the previous line.",
            "39:5: '{' should be on the previous line.",
        };
        verify(mCheckConfig, getPath("InputScopeInnerInterfaces.java"), expected);
    }

    @Test
    public void testNL() throws Exception
    {
        mCheckConfig.addAttribute("option", LeftCurlyOption.NL.toString());
        final String[] expected = {
            "49:14: '{' should be on a new line.",
            "53:14: '{' should be on a new line.",
            "58:18: '{' should be on a new line.",
            "62:18: '{' should be on a new line.",
            "67:12: '{' should be on a new line.",
            "72:18: '{' should be on a new line.",
        };
        verify(mCheckConfig, getPath("InputScopeInnerInterfaces.java"), expected);
    }

    @Test
    public void testNLOW() throws Exception
    {
        mCheckConfig.addAttribute("option", LeftCurlyOption.NLOW.toString());
        final String[] expected = {
            "8:1: '{' should be on the previous line.",
            "12:5: '{' should be on the previous line.",
            "21:5: '{' should be on the previous line.",
            "30:5: '{' should be on the previous line.",
            "39:5: '{' should be on the previous line.",
            "49:14: '{' should be on a new line.",
            "53:14: '{' should be on a new line.",
            "58:18: '{' should be on a new line.",
            "62:18: '{' should be on a new line.",
            "67:12: '{' should be on a new line.",
            "72:18: '{' should be on a new line.",
        };
        verify(mCheckConfig, getPath("InputScopeInnerInterfaces.java"), expected);
    }

    @Test
    public void testDefault2() throws Exception
    {
        final String[] expected = {
            "12:1: '{' should be on the previous line.",
            "17:5: '{' should be on the previous line.",
            "24:5: '{' should be on the previous line.",
            "31:5: '{' should be on the previous line.",
            "39:1: '{' should be on the previous line.",
            "41:5: '{' should be on the previous line.",
            "46:9: '{' should be on the previous line.",
            "53:9: '{' should be on the previous line.",
            "69:5: '{' should be on the previous line.",
            "77:5: '{' should be on the previous line.",
            "84:5: '{' should be on the previous line.",
        };
        verify(mCheckConfig, getPath("InputLeftCurlyMethod.java"), expected);
    }

    @Test
    public void testNL2() throws Exception
    {
        mCheckConfig.addAttribute("option", LeftCurlyOption.NL.toString());
        final String[] expected = {
            "14:39: '{' should be on a new line.",
            "21:20: '{' should be on a new line.",
            "34:31: '{' should be on a new line.",
            "43:24: '{' should be on a new line.",
            "56:35: '{' should be on a new line.",
            "60:24: '{' should be on a new line.",
            "74:20: '{' should be on a new line.",
            "87:31: '{' should be on a new line.",
        };
        verify(mCheckConfig, getPath("InputLeftCurlyMethod.java"), expected);
    }
    @Test
    public void testDefault3() throws Exception
    {
        final String[] expected = {
            "12:1: '{' should be on the previous line.",
            "15:5: '{' should be on the previous line.",
            "19:9: '{' should be on the previous line.",
            "21:13: '{' should be on the previous line.",
            "23:17: '{' should be on the previous line.",
            "30:17: '{' should be on the previous line.",
            "34:17: '{' should be on the previous line.",
            "42:13: '{' should be on the previous line.",
            "46:13: '{' should be on the previous line.",
            "52:9: '{' should be on the previous line.",
            "54:13: '{' should be on the previous line.",
            "63:9: '{' should be on the previous line.",
            "83:5: '{' should be on the previous line.",
            "89:5: '{' should be on the previous line.",
        };
        verify(mCheckConfig, getPath("InputLeftCurlyOther.java"), expected);
    }

    @Test
    public void testNL3() throws Exception
    {
        mCheckConfig.addAttribute("option", LeftCurlyOption.NL.toString());
        final String[] expected = {
            "26:33: '{' should be on a new line.",
            "91:19: '{' should be on a new line.",
            "97:19: '{' should be on a new line.",
        };
        verify(mCheckConfig, getPath("InputLeftCurlyOther.java"), expected);
    }

    @Test
    public void testMissingBraces() throws Exception
    {
        final String[] expected = {
            "12:1: '{' should be on the previous line.",
            "15:5: '{' should be on the previous line.",
            "21:5: '{' should be on the previous line.",
            "34:5: '{' should be on the previous line.",
            "51:5: '{' should be on the previous line.",
            "69:5: '{' should be on the previous line.",
            "105:5: '{' should be on the previous line.",
        };
        verify(mCheckConfig, getPath("InputBraces.java"), expected);
    }
}
