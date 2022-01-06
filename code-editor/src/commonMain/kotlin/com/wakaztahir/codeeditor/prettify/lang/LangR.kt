// Copyright (C) 2012 Jeffrey B. Arnold
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.wakaztahir.codeeditor.prettify.lang

import com.wakaztahir.codeeditor.prettify.parser.Prettify
import com.wakaztahir.codeeditor.prettify.parser.StylePattern
import com.wakaztahir.codeeditor.utils.new

import java.util.regex.Pattern

/**
 * This is similar to the lang-r.js in JavaScript Prettify.
 *
 *
 * To use, include prettify.js and this file in your HTML page.
 * Then put your code in an HTML tag like
 * <pre class="prettyprint lang-r"> code </pre>
 *
 *
 * Language definition from
 * http://cran.r-project.org/doc/manuals/R-lang.html.
 * Many of the regexes are shared  with the pygments SLexer,
 * http://pygments.org/.
 *
 *
 * Original: https://raw.github.com/jrnold/prettify-lang-r-bugs/master/lang-r.js
 *
 * @author jeffrey.arnold@gmail.com
 */
class LangR : Lang() {
    companion object {
        val fileExtensions: List<String>
            get() = listOf("r", "s", "R", "S", "Splus")
    }

    init {
        val _shortcutStylePatterns: MutableList<StylePattern> = ArrayList()
        val _fallthroughStylePatterns: MutableList<StylePattern> = ArrayList()
        _shortcutStylePatterns.new(
                Prettify.PR_PLAIN, Pattern.compile("^[\\t\\n\\r \\xA0]+"), null, "\t\n\r " + 0xA0.toChar().toString()
            )
        _shortcutStylePatterns.new(
                Prettify.PR_STRING, Pattern.compile("^\\\"(?:[^\\\"\\\\]|\\\\[\\s\\S])*(?:\\\"|$)"), null, "\""
            )
        _shortcutStylePatterns.new(
                Prettify.PR_STRING, Pattern.compile("^\\'(?:[^\\'\\\\]|\\\\[\\s\\S])*(?:\\'|$)"), null, "'"
            )
        _fallthroughStylePatterns.new(Prettify.PR_COMMENT, Pattern.compile("^#.*"))
        _fallthroughStylePatterns.new(
                Prettify.PR_KEYWORD, Pattern.compile("^(?:if|else|for|while|repeat|in|next|break|return|switch|function)(?![A-Za-z0-9_.])")
        )
        // hex numbes
        _fallthroughStylePatterns.new(
                Prettify.PR_LITERAL, Pattern.compile("^0[xX][a-fA-F0-9]+([pP][0-9]+)?[Li]?")
            )
        // Decimal numbers
        _fallthroughStylePatterns.new(
                Prettify.PR_LITERAL, Pattern.compile("^[+-]?([0-9]+(\\.[0-9]+)?|\\.[0-9]+)([eE][+-]?[0-9]+)?[Li]?")
        )
        // builtin symbols
        _fallthroughStylePatterns.new(
                Prettify.PR_LITERAL, Pattern.compile("^(?:NULL|NA(?:_(?:integer|real|complex|character)_)?|Inf|TRUE|FALSE|NaN|\\.\\.(?:\\.|[0-9]+))(?![A-Za-z0-9_.])")
        )
        // assignment, operators, and parens, etc.
        _fallthroughStylePatterns.new(
                Prettify.PR_PUNCTUATION, Pattern.compile("^(?:<<?-|->>?|-|==|<=|>=|<|>|&&?|!=|\\|\\|?|\\*|\\+|\\^|\\/|!|%.*?%|=|~|\\$|@|:{1,3}|[\\[\\](){};,?])")
        )
        // valid variable names
        _fallthroughStylePatterns.new(
                Prettify.PR_PLAIN, Pattern.compile("^(?:[A-Za-z]+[A-Za-z0-9_.]*|\\.[a-zA-Z_][0-9a-zA-Z\\._]*)(?![A-Za-z0-9_.])")
        )
        // string backtick
        _fallthroughStylePatterns.new(Prettify.PR_STRING, Pattern.compile("^`.+`"))
        setShortcutStylePatterns(_shortcutStylePatterns)
        setFallthroughStylePatterns(_fallthroughStylePatterns)
    }

    override fun getFileExtensions(): List<String> {
        return fileExtensions
    }
}