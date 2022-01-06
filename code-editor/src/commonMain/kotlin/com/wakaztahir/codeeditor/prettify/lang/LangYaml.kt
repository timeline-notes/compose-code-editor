// Copyright (C) 2010 ribrdb @ code.google.com
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

import java.util.regex.Pattern

/**
 * This is similar to the lang-yaml.js in JavaScript Prettify.
 *
 * All comments are adapted from the JavaScript Prettify.
 *
 *
 *
 * Registers a language handler for YAML.
 *
 * @author ribrdb
 */
class LangYaml : Lang() {
    companion object {
        val fileExtensions: List<String>
            get() = listOf("yaml", "yml")
    }

    init {
        val _shortcutStylePatterns: MutableList<StylePattern> = ArrayList()
        val _fallthroughStylePatterns: MutableList<StylePattern> = ArrayList()
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_PUNCTUATION,
                Pattern.compile("^[:|>?]+"),
                null,
                ":|>?"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_DECLARATION,
                Pattern.compile("^%(?:YAML|TAG)[^#\\r\\n]+"),
                null,
                "%"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_TYPE,
                Pattern.compile("^[&]\\S+"),
                null,
                "&"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_TYPE,
                Pattern.compile("^!\\S*"),
                null,
                "!"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_STRING,
                Pattern.compile("^\"(?:[^\\\\\"]|\\\\.)*(?:\"|$)"),
                null,
                "\""
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_STRING,
                Pattern.compile("^'(?:[^']|'')*(?:'|$)"),
                null,
                "'"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_COMMENT,
                Pattern.compile("^#[^\\r\\n]*"),
                null,
                "#"
            )
        )
        _shortcutStylePatterns.add(
            listOf(
                Prettify.PR_PLAIN,
                Pattern.compile("^\\s+"),
                null,
                " \t\r\n"
            )
        )
        _fallthroughStylePatterns.add(
            listOf(
                Prettify.PR_DECLARATION,
                Pattern.compile("^(?:---|\\.\\.\\.)(?:[\\r\\n]|$)")
            )
        )
        _fallthroughStylePatterns.add(listOf(Prettify.PR_PUNCTUATION, Pattern.compile("^-")))
        _fallthroughStylePatterns.add(
            listOf(
                Prettify.PR_KEYWORD,
                Pattern.compile("^\\w+:[ \\r\\n]")
            )
        )
        _fallthroughStylePatterns.add(listOf(Prettify.PR_PLAIN, Pattern.compile("^\\w+")))
        setShortcutStylePatterns(_shortcutStylePatterns)
        setFallthroughStylePatterns(_fallthroughStylePatterns)
    }

    override fun getFileExtensions(): List<String> {
        return fileExtensions
    }
}