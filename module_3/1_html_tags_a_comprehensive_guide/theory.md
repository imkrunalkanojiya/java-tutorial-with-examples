# Introduction to HTML

HTML (HyperText Markup Language) is the standard markup language for creating web pages. It provides the structure and content of web pages through various tags that define different elements.

## Key HTML Tags

### 1. Anchor Tag `<a>`
The anchor tag creates hyperlinks to other web pages, files, email addresses, or any other URL.

```html
<!-- Basic link -->
<a href="https://www.example.com">Click here</a>

<!-- Link to an email -->
<a href="mailto:contact@example.com">Send Email</a>

<!-- Link that opens in a new tab -->
<a href="https://www.example.com" target="_blank">Open in New Tab</a>
```

### 2. Form Tag `<form>`
The form tag creates an HTML form for user input, typically used to collect and submit data.

```html
<form action="/submit" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Login">
</form>
```

### 3. Table Tag `<table>`
Tables are used to organize and display data in rows and columns.

```html
<table border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>John Doe</td>
            <td>25</td>
        </tr>
        <tr>
            <td>Jane Smith</td>
            <td>30</td>
        </tr>
    </tbody>
</table>
```

### 4. Image Tag `<img>`
The image tag embeds images into web pages.

```html
<!-- Basic image -->
<img src="image.jpg" alt="Description of image">

<!-- Image with width and height -->
<img src="logo.png" alt="Company Logo" width="300" height="200">
```

### 5. List Tags
HTML provides two types of lists:

#### Unordered List `<ul>`
```html
<ul>
    <li>Apple</li>
    <li>Banana</li>
    <li>Orange</li>
</ul>
```

#### Ordered List `<ol>`
```html
<ol>
    <li>First step</li>
    <li>Second step</li>
    <li>Third step</li>
</ol>
```

### 6. Paragraph Tag `<p>`
Used to define paragraphs of text.

```html
<p>This is a paragraph of text. Paragraphs are block-level elements that provide structure to written content.</p>
```

### 7. Line Break Tag `<br>`
Creates a single line break.

```html
First line<br>
Second line
```

### 8. Label Tag `<label>`
Associates a text label with a form input, improving accessibility and usability.

```html
<form>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    
    <label for="subscribe">
        <input type="checkbox" id="subscribe" name="subscribe">
        Subscribe to newsletter
    </label>
</form>
```

## Best Practices
- Always include the `alt` attribute in `<img>` tags for accessibility
- Use semantic HTML tags to provide meaning to your content
- Properly nest and close your tags
- Use `<label>` tags to improve form usability
- Keep your HTML clean and well-structured

## Common Attributes
- `href`: Specifies the URL for anchor tags
- `src`: Specifies the source for image and script tags
- `alt`: Provides alternative text for images
- `class`: Assigns one or more CSS classes
- `id`: Provides a unique identifier for an element

## Browser Compatibility
Most modern browsers support these HTML tags consistently. Always test your web pages across different browsers to ensure compatibility.