package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// TODO add Controller Annotation
// Tells Spring Boot that this CLass represents a Web Controller
// There are methods in this class that should be set up to Handle Http requests
@Controller
public class HelloController {

    // Handles request at path /hello
    @GetMapping("hello") // Tells spring boot that this method should handle GET requests
    @ResponseBody // tells spring boot that this method will return a plain text Http response
    public String hello() {
        return "Hello, Spring";
    }

    // Handles request at path /goodbye
    @GetMapping("goodbye") // Tells spring boot that this method should handle GET requests
    @ResponseBody // tells spring boot that this method will return a plain text Http response
    public String goodbye() {
        return "Goodbye, Spring";
    }
    // Dynamic request handler because it responds differently based on the data it is given
    // Handles request of the form /hello?name=LaunchCode
    // QUERY PARAMETER
    @GetMapping ("helloParameter")
    @ResponseBody
    public String helloWithQueryParameter(@RequestParam String name) {
        return "Hello, " + name + " !!! (with @RequestParm)";
    }

    // Handles request of the URL directly /hello/LaunchCode --(WITH PATH VARIABLE or path parameter)
    // instead of name=LaunchCode it take the URL segment directly as a variable. They variable is part of the path
    // PATH PARAMETER
    @GetMapping ("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + " !!!!!! (with @PathVariable)";
    }

    // REQUESTMAPPING : using RequestMapping to get a POST request. With a QUERY PARAMETER (@RequestParam)
    //below line
    //      value = helloFormPost specifies that this method is wired up to live at the route /helloFormPost
    //      and should accept both GET and POST request
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloFormRequestMapping")
    @ResponseBody
    public String helloWithQueryParameterAndRequestMapping(@RequestParam String name) {
        return "Hello, " + name + " !!! (with @RequestMapping via a POST";
    }


    // Handles request from a FORM
    // with a GET request (default value when not specified in the opening form tag
//    @GetMapping ("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = 'helloParameter'>" + // submit a request to /helloParameter
//                "<input type ='text' name = 'name'/>" +
//                "<input type = 'submit' value = 'Greet Me!'/>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // Handles request from a FORM
    // with a POST request ( must add to opening form tag) : method = 'post'
    @GetMapping ("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form method = 'post' action = 'helloFormRequestMapping'>" + // submit a request to /helloFormRequestMapping
                "<input type ='text' name = 'name'/>" +
                "<input type = 'submit' value = 'Greet Me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
