# CSS Pseudo-Classes: Styling Element States

## What are Pseudo-Classes?

Pseudo-classes are CSS selectors that style elements based on a specific state or condition. They allow you to create dynamic and interactive styles without using JavaScript.

## Common Pseudo-Classes

### 1. `:hover`
Applies styles when the mouse hovers over an element.
```css
a:hover {
    color: red;
    text-decoration: underline;
}
```

### 2. `:focus`
Styles an element when it receives keyboard focus or is selected.
```css
input:focus {
    outline: 2px solid blue;
    box-shadow: 0 0 5px rgba(0,0,0,0.3);
}
```

### 3. `:active`
Styles an element when it's being actively clicked or pressed.
```css
button:active {
    background-color: darkblue;
    transform: scale(0.95);
}
```

### 4. `:first-child`
Selects the first child element within its parent.
```css
li:first-child {
    font-weight: bold;
}
```

### 5. `:last-child`
Selects the last child element within its parent.
```css
li:last-child {
    color: gray;
}
```

### 6. `:nth-child()`
Selects elements based on their position among siblings.
```css
/* Select every even row */
tr:nth-child(even) {
    background-color: #f2f2f2;
}
```

### 7. `:not()`
Selects elements that do not match the given selector.
```css
/* Style all inputs except checkbox */
input:not([type="checkbox"]) {
    border: 1px solid #ccc;
}
```

## Advanced Pseudo-Classes

### `:checked`
Styles form elements that are checked.
```css
input[type="checkbox"]:checked {
    background-color: green;
}
```

### `:disabled`
Styles form elements that are disabled.
```css
button:disabled {
    opacity: 0.5;
    cursor: not-allowed;
}
```

## Best Practices

1. Use pseudo-classes to enhance user interaction
2. Keep styles subtle and meaningful
3. Ensure good color contrast
4. Consider accessibility
5. Test across different browsers

## Performance Considerations

- Pseudo-classes are processed by the browser
- Overusing complex pseudo-class selectors can impact performance
- Prioritize simple, clear interactions

## Browser Compatibility

Most modern browsers support common pseudo-classes.
Always test your styles across different browsers and devices.

## Practical Applications

- Interactive navigation menus
- Form validation styling
- Highlighting active states
- Creating zebra-striped tables
- Improving user experience through visual feedback

## Common Mistakes to Avoid

- Don't overuse pseudo-classes
- Maintain consistent design patterns
- Ensure readability and accessibility
- Test across different devices and browsers

## Example Combinations

```css
/* Complex pseudo-class combination */
a:link:hover {
    color: blue;
    text-decoration: underline;
}

/* Multiple state handling */
input:focus:valid {
    border-color: green;
}
```