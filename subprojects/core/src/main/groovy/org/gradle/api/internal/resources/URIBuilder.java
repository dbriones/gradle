/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.resources;

import java.net.URI;

/**
 * by Szczepan Faber, created at: 12/13/11
 */
public class URIBuilder {
    private final URI uri;
    private String schemePrefix = "";

    public URIBuilder(URI uri) {
        this.uri = uri;
    }

    public URIBuilder schemePrefix(String schemePrefix) {
        assert schemePrefix != null;
        this.schemePrefix = schemePrefix;
        return this;
    }

    public URI build() {
        String prefix = (schemePrefix.length() > 0) ? schemePrefix + ":" : "";
        try {
            return new URI(prefix + uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uri.getPath(), uri.getQuery(), uri.getFragment());
        } catch (Exception e) {
            throw new RuntimeException("Unable to build URI based on supplied URI: " + uri, e);
        }
    }
}