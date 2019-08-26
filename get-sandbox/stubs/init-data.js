var initItems = [
    {
        id: "0",
        date: '2011-01-01',
        title: "React",
        url: "https://facebook.github.io/react/img/logo.svg",
        detail: "React (sometimes styled React.js or ReactJS) is an open-source JavaScript",
        more: "React (sometimes styled React.js or ReactJS) is an open-source JavaScript library[2] for building user interfaces."
        + "It is maintained by Facebook, Instagram and a community of individual developers and corporations.[3][4][5] According to JavaScript analytics service Libscore, React is currently being used on the websites of Netflix, Imgur, Buffer, Bleacher Report, Feedly, Airbnb, SeatGeek, HelloSign, Walmart, and others.[6]"
        + "React allows developers to create large web applications that use data which can change over time, without reloading the page. Its main goal is to be fast, simple and scalable. React processes only user interfaces in applications. This corresponds to View in the Model-View-Controller (MVC) template, and can be used in combination with other JavaScript libraries or frameworks in MVC, such as AngularJS.[7]"
    },
    {
        id: "1",
        title: "Angular",
        url: "https://angularjs.org/img/angularjs-for-header-only.svg",
        detail: "AngularJS is what HTML would have been, had it been designed for building web-apps. Declarative templates with data-binding, MVW, MVVM, MVC, ...",
        more: "Angular (commonly referred to as Angular 2+ or Angular 2) is a TypeScript-based open-source front-end web application platform led by the Angular Team at Google and by a community of individuals and corporations to address all of the parts of the developer's workflow while building complex web applications. Angular is a complete rewrite from the same team that built AngularJS."
    },
    {
        id: "2",
        title: "Babel",
        url: "https://babeljs.io/images/logo.svg",
        detail: "The compiler for writing next generation JavaScript.",
        more: "Babel is a community-driven tool that helps you write code in the latest version of JavaScript."
        + "When your supported environments don't support certain features natively, Babel will help you compile those features down to a supported version."
    },
    {
        id: "3",
        title: "Elixir",
        url: "https://elixir-lang.org/images/logo/logo.png",
        detail: "Elixir is a dynamic, functional language designed for building scalable and maintainable applications. Elixir leverages the Erlang VM, known for running low-latency, distributed and fault-tolerant systems",
        more: "no more"
    },
    {
        id: "4",
        title: "Erlang",
        url: "https://www.erlang.org/img/erlang.png",
        detail: "Erlang is a general-purpose, concurrent, functional programming language, as well as a garbage-collected runtime system. The term Erlang is used ...",
        more: "no more"
    },
    {
        id: "5",
        title: "Java",
        url: "https://www.techytalk.info/wp-content/uploads/2012/03/java-logo.jpg",
        detail: "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few ",
        more: "no more"
    },
    {
        id: "6",
        title: "Ruby",
        url: "https://www.ruby-lang.org/images/header-ruby-logo@2x.png",
        detail: "A dynamic, open source programming language with a focus on simplicity and productivity. It has an elegant syntax that is natural to read and easy to write.",
        more: "no more"
    },
    {
        id: "7",
        title: "Clojure",
        url: "https://clojure.org/images/clojure-logo-120b.png",
        detail: "Clojure is a dynamic, general-purpose programming language, combining the approachability and interactive development of a scripting language with an ...",
        more: "no more"
    },
    {
        id: "8",
        title: "Python",
        url: "https://www.python.org/static/img/python-logo-large.png?1414305901",
        detail: "Python is a widely used high-level programming language for general-purpose programming, created by Guido van Rossum and first released in 1991.",
        more: "no more"
    },
    {
        id: "9",
        title: "Javascript",
        url: "https://www.javascript.com/images/pages/home/img-console.svg",
        detail: "JavaScript often abbreviated as JS, is a high-level, dynamic, untyped, interpreted run-time language. It has been standardized in the ECMAScript language ...",
        more: "no more"
    }
];

exports.getInitTerms = function () {
    return initItems;
};
