4clojure-solutions
------------------

My solutions to https://www.4clojure.com/problems

How the code is written and organized
-------------------------------------

Each problem gets its ``.clj`` source file in ``src/solutions``. The name of the
source file is the problem number and name, and this is the name of the
namespace as well (with the customary dashes-to-underscores transformation
applied).

Within each file, a function is defined as:

.. sourcecode:: clojure

    (def function-name
      (fn [arg ...]
        ...))

The reason for defining functions this way is that 4clojure requires an unnamed
function to be pasted into its code box, so a ``defn`` won't do. This way the
code starting from the ``(fn ...)`` line can be copy pasted (with the trailing
``)`` removed).
