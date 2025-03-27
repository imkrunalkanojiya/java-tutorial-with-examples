# CSS ID and Class Selectors

## Understanding ID and Class Selectors

### ID Selectors (`#`)
- Unique identifier for a single element
- Should be used only once per page
- Highest specificity in CSS
- Used for unique, singular elements

### Class Selectors (`.`)
- Reusable identifier
- Can be applied to multiple elements
- Lower specificity than ID
- Used for repeatable styles across elements

## Syntax and Usage

### ID Selector
```html
<!-- HTML -->
<div id="main-header">Unique Header</div>
```

```css
/* CSS */
#main-header {
    background-color: navy;
    color: white;
    padding: 20px;
}
```

### Class Selector
```html
<!-- HTML -->
<p class="highlight">First highlighted paragraph</p>
<p class="highlight">Second highlighted paragraph</p>
```

```css
/* CSS */
.highlight {
    background-color: yellow;
    font-weight: bold;
    padding: 10px;
}
```

## Key Differences

| Characteristic | ID Selector | Class Selector |
|---------------|-------------|----------------|
| Uniqueness | Must be unique | Can be reused |
| Syntax | `#identifier` | `.classname` |
| Usage | One per page | Multiple per page |
| Specificity | Highest | Lower |

## Best Practices

### ID Best Practices
- Use for unique page elements
- Ideal for JavaScript targeting
- Good for creating anchor links
- Use sparingly

### Class Best Practices
- Use for repeatable styles
- Create modular, reusable designs
- Combine multiple classes
- More flexible for styling

## Advanced Usage

### Multiple Classes
```html
<div class="card big-card blue-theme">
    Combined styling through multiple classes
</div>
```

```css
.card {
    border: 1px solid gray;
}

.big-card {
    width: 300px;
    height: 200px;
}

.blue-theme {
    background-color: #e6f2ff;
    color: navy;
}
```

### Combining Selectors
```css
/* Targeting a specific element with a class */
div.highlight {
    border: 2px solid green;
}

/* Nested selectors */
.container .item {
    margin: 10px;
}
```

## Common Mistakes to Avoid

1. Don't overuse IDs
2. Avoid using IDs for styling
3. Keep class names semantic and descriptive
4. Use meaningful naming conventions
5. Understand CSS specificity rules

## Performance Considerations

- IDs are faster for DOM selection
- Classes provide more flexibility
- Use the right selector for the right job

## Practical Examples

### JavaScript Targeting
```html
<form id="login-form">
    <input class="input-field" type="text">
    <input class="input-field" type="password">
</form>
```

```javascript
// Easy targeting with ID
const loginForm = document.getElementById('login-form');

// Targeting multiple elements with class
const inputFields = document.getElementsByClassName('input-field');
```

## Specificity Calculation

ID selectors have higher specificity than class selectors:
- ID: 100 points
- Class: 10 points
- Element: 1 point

This means ID styles will override class styles when conflicts occur.