# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#  http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

# -*- coding: utf-8 -*-
from datetime import date
import sys, os
needs_sphinx = '1.0'
this = os.path.dirname(os.path.abspath(__file__))

# If your extensions are in another directory, add it here. If the directory
# is relative to the documentation root, use os.path.abspath to make it
# absolute, like shown here.
#sys.path.append(os.path.join(os.pardir, "tests"))
sys.path.append(os.path.join(this, "_ext"))

#sys.path.append(os.path.abspath('_themes'))
# General configuration
# ---------------------

extensions = ['sphinx.ext.autodoc',
              'sphinx.ext.coverage',
              'sphinx.ext.pngmath',
              'sphinx.ext.intersphinx',
              'rst2pdf.pdfbuilder']

html_show_sphinx = False

# Add any paths that contain templates here, relative to this directory.
templates_path = ['_templates']

# The suffix of source filenames.
source_suffix = '.rst'
source_encoding = 'utf-8-sig'
# The master toctree document.
master_doc = 'index'

language= 'fr'

# General information about the project.
project = '${project.name}'
copyright = '${project.inceptionYear}-' + str(date.today().year)+' ${project.organization.name}'

# The version info for the project you're documenting, acts as replacement for
# |version| and |release|, also used in various other places throughout the
# built documents.
#
# The short X.Y version.
version = '${project.version}'
# The full version, including alpha/beta/rc tags.
release = '${project.version}'

exclude_trees = ['.build']

# If true, '()' will be appended to :func: etc. cross-reference text.
add_function_parentheses = True

#intersphinx_mapping = {
        #"http://docs.python.org/dev": None,
        #"http://kombu.readthedocs.org/en/latest/": None,
        #"http://django-celery.readthedocs.org/en/latest": None,
#}

# The name of the Pygments (syntax highlighting) style to use.
pygments_style = 'trac'

# Add any paths that contain custom static files (such as style sheets) here,
# relative to this directory. They are copied after the builtin static files,
# so a file named "default.css" will overwrite the builtin "default.css".
html_static_path = ['_static']

html_use_smartypants = True

# If false, no module index is generated.
html_use_modindex = True

# If false, no index is generated.
html_use_index = True

#latex_documents = [
#  ('index', 'Celery.tex', ur'Celery Documentation',
#   ur'Ask Solem & Contributors', 'manual'),
#]

html_theme = "ot"
html_theme_path = ["_themes"]
html_sidebars = {
    'index': ['sidebarlogo.html', 'sidebarintro.html', 'sourcelink.html','searchbox.html'],
    '**': ['sidebarlogo.html', 'localtoc.html', 'relations.html', 'sourcelink.html', 'searchbox.html']
}

#-------

add_function_parentheses = True

# -- Options for HTML output ---------------------------------------------------



#html_use_smartypants = True

htmlhelp_basename = project+'doc'


# -- Options for PDF output ---------------------------------------------------
#pdf_documents = [
    #('index', u'Sphinx-Maven', u'Sphinx-Maven', u'Thomas Dudziak'),
#]

